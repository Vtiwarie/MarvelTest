package com.example.marveltest

import android.app.Application
import androidx.lifecycle.Lifecycle
import androidx.room.Room
import com.example.marveltest.data.MarvelDatabase
import com.example.marveltest.data.dao.ComicsDao
import com.example.marveltest.data.entity.Comic
import com.example.marveltest.ui.list.ListPresenter
import com.example.marveltest.ui.list.ListView
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import javax.inject.Inject

/**
 * @author Vishaan Tiwarie
 *
 * Test class for the list screen logic
 */
class ListPresenterTest {

    @Inject
    lateinit var listPresenter: ListPresenter

    lateinit var db: MarvelDatabase
    lateinit var comicsDao: ComicsDao

    private var application = Mockito.mock(Application::class.java)
    private val view = Mockito.mock(ListView::class.java)
    private val lifecycle = Mockito.mock(Lifecycle::class.java)
    private val throwable = Mockito.mock(Throwable::class.java)
    private val mockComicsDao = Mockito.mock(ComicsDao::class.java)
//    private val testScheduler = TestScheduler()

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        createDB()
        val component = DaggerTestComponent.builder()
            .testModule(TestModule(application, mockComicsDao))
            .build()

        Mockito.`when`(application.getString(R.string.base_url))
            .thenReturn("https://gateway.marvel.com/")

        component.inject(this)

        listPresenter.attachView(view, lifecycle)
    }

    private fun createDB() {
        db = Room.inMemoryDatabaseBuilder(
            application, MarvelDatabase::class.java
        ).build()
        comicsDao = db.comicsDao()
    }

    @Test
    fun testShowComics() {
        listPresenter.fetchAndSaveComics()
        Mockito.`when`(application.getString(R.string.base_url))
            .thenReturn("https://gateway.marvel.com/")
        Mockito.`when`(application.getString(R.string.apikey))
            .thenReturn("adbaf8fc9e08fc3cac65475dfc057528")
        Mockito.`when`(application.getString(R.string.private_key))
            .thenReturn("18df06e2d73e9fc51f80600ffa988c6265855d4e")

        Mockito.verify(view).showComicsList(Mockito.anyList<Comic>())
    }

    @After
    fun closeDB() {
        db.close()
    }

    fun <T> any(): T = Mockito.any<T>()
}
