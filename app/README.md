# Tenant Management System

An Android app for landlords to record tenants, see total rent, and call tenants.

## Download
Latest APK: see **Releases** on the right of this page.

## Features
- Register and log in
- Dashboard with number of tenants and total rent
- Add tenants and view all tenants (saved with Room)
- Call a tenant, options menu and navigation drawer

## Architecture
ui/ Activities, Fragments and TenantViewModel (UI layer)
data/ Tenant, TenantDao, TenantDatabase, TenantRepository (data layer)

Screens → TenantViewModel (LiveData) → TenantRepository → Room

## Team
| Stage | Member             | Admission No. | Pull request |
|---|--------------------|---------------|---|
| 1 Lead | Kristian Kinyua    | 171047        | No pull request
| 2 ViewModel | Stanley Kiriama    | 190515        | https://github.com/MuneneKristian/TenantManagementSystem/pull/1 |
| 3 Room | Kamau Anne Wairimu | 191978        | https://github.com/MuneneKristian/TenantManagementSystem/pull/2 |
| 4 Screens | Hope Ndichu        | 192275        | https://github.com/MuneneKristian/TenantManagementSystem/pull/3 |
| 5 Data integration | Mary Wamui         | 191731        | https://github.com/MuneneKristian/TenantManagementSystem/pull/4 |
| 6 Release | Daisy Adalia       | 189926        | (link) |