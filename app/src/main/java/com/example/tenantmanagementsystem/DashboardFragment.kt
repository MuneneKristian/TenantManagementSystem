package com.example.tenantmanagementsystem

import android.util.Log
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tenantmanagementsystem.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!

    // 1. The Fragment object is created
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("TENANT_LIFECYCLE", "DashboardFragment: onCreate")
    }

    // 2. Create the Fragment's view from its XML layout
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d("TENANT_LIFECYCLE", "DashboardFragment: onCreateView")

        _binding = FragmentDashboardBinding.inflate(
            inflater,
            container,
            false
        )

        return binding.root
    }

    // 3. The view is ready for setup
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("TENANT_LIFECYCLE", "DashboardFragment: onViewCreated")

        // Display tenant count and total rent
        val tenantCount = TenantRepository.tenants.size
        val totalRent = TenantRepository.totalRent()

        binding.tenantCountTextView.text = "Tenants\n$tenantCount"
        binding.totalRentTextView.text =
            "Total rent\nKSh %,.0f".format(totalRent)

        // Navigate to Add Tenant screen
        binding.addTenantButton.setOnClickListener {
            val action =
                DashboardFragmentDirections
                    .actionDashboardFragmentToAddTenantFragment()

            findNavController().navigate(action)
        }

        // Navigate to View Tenants screen
        binding.viewTenantsButton.setOnClickListener {
            val action =
                DashboardFragmentDirections
                    .actionDashboardFragmentToViewTenantsFragment()

            findNavController().navigate(action)
        }
    }

    // 4. The Fragment becomes visible
    override fun onStart() {
        super.onStart()
        Log.d("TENANT_LIFECYCLE", "DashboardFragment: onStart")
    }

    // 5. The Fragment becomes interactive
    override fun onResume() {
        super.onResume()
        Log.d("TENANT_LIFECYCLE", "DashboardFragment: onResume")
    }

    // 6. The Fragment is about to lose interaction
    override fun onPause() {
        super.onPause()
        Log.d("TENANT_LIFECYCLE", "DashboardFragment: onPause")
    }

    // 7. The Fragment is no longer visible
    override fun onStop() {
        super.onStop()
        Log.d("TENANT_LIFECYCLE", "DashboardFragment: onStop")
    }

    // 8. The Fragment's view is destroyed
    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("TENANT_LIFECYCLE", "DashboardFragment: onDestroyView")
        _binding = null
    }

    // 9. The Fragment object itself is destroyed
    override fun onDestroy() {
        super.onDestroy()
        Log.d("TENANT_LIFECYCLE", "DashboardFragment: onDestroy")
    }
}
