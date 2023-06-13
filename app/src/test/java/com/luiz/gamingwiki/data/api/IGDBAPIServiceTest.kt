package com.luiz.gamingwiki.data.api

import com.google.common.truth.Truth
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class IGDBAPIServiceTest {
    private lateinit var service: IGDBAPIService
    private lateinit var server: MockWebServer

    @Before
    fun setUp() {
        server = MockWebServer()
        service = Retrofit.Builder()
            .baseUrl(server.url(""))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(IGDBAPIService::class.java)
    }

    private fun enqueueMockResponse(
        fileName:String
    ){
        val inputStream = javaClass.classLoader!!.getResourceAsStream(fileName)
        val source = inputStream.source().buffer()
        val mockResponse = MockResponse()
        mockResponse.setBody(source.readString(Charsets.UTF_8))
        server.enqueue(mockResponse)
    }

    @Test
    fun getBestRatingGames_sentRequest_receivedExpected(){
        runBlocking {
            enqueueMockResponse("igdbresponse.json")
            val responseBody = service.getBestRatingGames(
                "fields artworks.url,artworks.width,category,created_at,franchise,genres.name,name,similar_games.artworks.url,similar_games.artworks.width,similar_games.category,similar_games.created_at,franchise,similar_games.genres.name,similar_games.name,similar_games.platforms.abbreviation,similar_games.platforms.name,similar_games.slug,similar_games.status,similar_games.storyline,similar_games.summary,similar_games.themes.name;platforms.abbreviation,platforms.name,slug,status,storyline,summary,themes.name;sort rating_count desc;where rating != null;"
            ).body()
            val request = server.takeRequest()
            Truth.assertThat(responseBody).isNotNull()
            Truth.assertThat(request.path).isEqualTo("/v4/games")
        }
    }

    @After
    fun tearDown() {
        server.shutdown()
    }
}