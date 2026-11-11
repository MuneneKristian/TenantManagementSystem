package ui.tenants

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import data.repository.TenantRepository
import com.example.tenantmanagementsystem.databinding.FragmentViewTenantsBinding

class ViewTenantsFragment : Fragment() {

    private var _binding: FragmentViewTenantsBinding? = null
    private val binding get() = _binding!!

    // Receive data passed through Safe Args
    private val args: ViewTenantsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentViewTenantsBinding.inflate(
            inflater,
            container,
            false
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Get the newly added tenant, if one was passed
        val newTenant = args.newTenant

        // Display the newly added tenant
        binding.tenant = newTenant

        // Hide the "Just added" section if no tenant was passed
        if (newTenant == null) {
            binding.newTenantGroup.visibility = View.GONE
        }

        // Open the phone dialer with the tenant's number
        binding.callButton.setOnClickListener {
            if (newTenant != null) {
                val intent = Intent(
                    Intent.ACTION_DIAL,
                    Uri.parse("tel:${newTenant.phone}")
                )

                startActivity(intent)
            }
        }

        // Display all saved tenants
        val tenants = TenantRepository.tenants

        if (tenants.isEmpty()) {
            binding.allTenantsTextView.text =
                "No tenants yet. Add one from the Dashboard."
        } else {
            binding.allTenantsTextView.text =
                tenants.joinToString("\n\n") { it.summary() }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}