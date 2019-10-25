package net.wetfish.playasoftvolunteers.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import net.wetfish.playasoftvolunteers.ui.departments.DepartmentListViewModel
import net.wetfish.playasoftvolunteers.ui.events.EventListViewModel
import net.wetfish.playasoftvolunteers.ui.login.LoginViewModel
import net.wetfish.playasoftvolunteers.ui.roles.RoleListViewModel
import net.wetfish.playasoftvolunteers.ui.shiftDetails.ShiftDetailsViewModel

/**
 * Created by  on 10/24/2019.
 */

@Suppress("unused")
@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun bindThemeViewModel(viewModel: LoginViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(EventListViewModel::class)
    abstract fun bindLegoSetViewModel(viewModel: EventListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DepartmentListViewModel::class)
    abstract fun bindLegoSetViewModel(viewModel: DepartmentListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(RoleListViewModel::class)
    abstract fun bindLegoSetViewModel(viewModel: RoleListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ShiftDetailsViewModel::class)
    abstract fun bindLegoSetsViewModel(viewModel: ShiftDetailsViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
