package com.yuoku.androidRxDemo.Models

import io.reactivex.*
import io.reactivex.rxkotlin.*

class HelloWorld {

    val theFlowable = Flowable.just("Hello Rx")

    /**
     * Output data of Flowable argument to console.
     */
    fun sayHello() {

        // output "Hello Rx"
        theFlowable
            .subscribe(System.out::println)
            .dispose()

        // output "Hello Rx!!"
        theFlowable
            .map { "$it!!" }
            .subscribe(System.out::println)
            .dispose()

        // output "hashCode: -728087404"
        theFlowable
            .map { it.hashCode() }
            .map { "hashCode: $it" }
            .subscribe(System.out::println)
            .dispose()
    }

    /**
     * Extract words of 5 characters.
     */
    fun extractWordsFiveCharacters(words: List<String>) {

        words.toObservable() // extension function for Iterables
            .filter { it.length == 5 }
            .subscribeBy(  // named arguments for lambda Subscribers
                onNext = { println(it) },
                onError =  { it.printStackTrace() },
                onComplete = { println("Done!!") }
            )
            .dispose()
    }
}