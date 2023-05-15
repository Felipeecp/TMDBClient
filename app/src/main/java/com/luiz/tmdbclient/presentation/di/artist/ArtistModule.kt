package com.luiz.tmdbclient.presentation.di.artist

import com.luiz.tmdbclient.domain.usecase.GetArtistsUseCase
import com.luiz.tmdbclient.domain.usecase.UpdateArtistsUseCase
import com.luiz.tmdbclient.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {
    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistsUseCase: GetArtistsUseCase,
        updateArtistsUseCase: UpdateArtistsUseCase
    ): ArtistViewModelFactory {
        return ArtistViewModelFactory(
            getArtistsUseCase,
            updateArtistsUseCase
        )
    }

}