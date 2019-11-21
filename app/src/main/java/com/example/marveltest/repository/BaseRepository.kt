package com.example.irokutest.repository

import io.realm.Realm
import io.realm.RealmObject

abstract class BaseRepository {
    protected fun getRealm() = Realm.getDefaultInstance()

    fun update(action: () -> Unit) {
        getRealm().executeTransaction {
            action()
        }
    }

    fun <T : RealmObject> insertOrUpdate(action: () -> T) {
        getRealm().executeTransaction {
            it.insertOrUpdate(action())
        }
    }

    fun <T : RealmObject> insertOrUpdateList(movies: List<T>) {
        getRealm().executeTransaction {
            it.insertOrUpdate(movies)
        }
    }
}