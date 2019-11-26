package com.example.marveltest

import android.app.Application
import androidx.lifecycle.Lifecycle
import com.example.marveltest.data.dao.ComicsDao
import com.example.marveltest.data.entity.Comic
import com.example.marveltest.ui.list.ListPresenter
import com.example.marveltest.ui.list.ListView
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import javax.inject.Inject

/**
 * @author Vishaan Tiwarie
 *
 * Test class for the list screen logic
 */
class ListPresenterTest {

    @Inject
    lateinit var listPresenter: ListPresenter

    private var application = Mockito.mock(Application::class.java)
    private val view = Mockito.mock(ListView::class.java)
    private val lifecycle = Mockito.mock(Lifecycle::class.java)
    private val mockComicsDao = Mockito.mock(ComicsDao::class.java)

    @Before
    fun setUp() {
        val component = DaggerTestComponent.builder()
            .testModule(TestModule(application, mockComicsDao))
            .build()

        Mockito.`when`(application.getString(R.string.base_url))
            .thenReturn("https://gateway.marvel.com/")

        component.inject(this)

        listPresenter.attachView(view, lifecycle)
    }

    @Test
    fun testFetchComics() {
        Mockito.`when`(application.getString(R.string.base_url))
            .thenReturn("https://gateway.marvel.com/")
        Mockito.`when`(application.getString(R.string.apikey))
            .thenReturn("adbaf8fc9e08fc3cac65475dfc057528")
        Mockito.`when`(application.getString(R.string.private_key))
            .thenReturn("18df06e2d73e9fc51f80600ffa988c6265855d4e")

        runBlocking {
            listPresenter.comicsRepository.fetchAndSaveComicsHelper()
        }
        Mockito.verify(mockComicsDao).saveItems(Mockito.anyList<Comic>())
    }
}
