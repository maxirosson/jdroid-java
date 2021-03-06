package com.jdroid.java.firebase.database

import com.firebase.client.Firebase
import com.firebase.client.FirebaseError
import com.jdroid.java.exception.UnexpectedException

class FirebaseCompletionListener : Firebase.CompletionListener {

    private val done = FirebaseCountDownLatch()

    override fun onComplete(firebaseError: FirebaseError?, firebase: Firebase) {
        if (firebaseError != null) {
            done.firebaseException = FirebaseException(firebaseError)
        }
        done.countDown()
    }

    fun waitOperation() {
        try {
            done.await()
            done.firebaseException?.let {
                throw it
            }
        } catch (e: InterruptedException) {
            throw UnexpectedException(e)
        }
    }
}
