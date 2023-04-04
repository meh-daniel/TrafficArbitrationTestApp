package traffic.arbitration.test.app.ru.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import traffic.arbitration.test.app.ru.data.AttributionRepositoryImpl
import traffic.arbitration.test.app.ru.data.nw.ServerApi
import traffic.arbitration.test.app.ru.domain.AttributionRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {
    @Provides
    @Singleton
    fun provideSessionRepository(
        api: ServerApi
    ) : AttributionRepository {
        return AttributionRepositoryImpl(api)
    }
}