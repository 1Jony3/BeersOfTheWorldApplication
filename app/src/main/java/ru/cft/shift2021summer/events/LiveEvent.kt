package ru.cft.shift2021summer.events

class LiveEvent : SingleLiveEvent<Unit>() {

    operator fun invoke() {
        this.value = Unit
    }
}