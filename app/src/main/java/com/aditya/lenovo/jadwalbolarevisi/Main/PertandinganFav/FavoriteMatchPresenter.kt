package com.aditya.lenovo.jadwalbolarevisi.Main.PertandinganFav

import com.aditya.lenovo.jadwalbolarevisi.Entitas.Event
import com.aditya.lenovo.jadwalbolarevisi.Entitas.repository.LocalRepositoryImpl
import com.aditya.lenovo.jadwalbolarevisi.Entitas.repository.MatchRepositoryImpl
import com.aditya.lenovo.jadwalbolarevisi.scheduler.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

class FavoriteMatchPresenter(val mView: FavoriteMatchContract.View,
                             val matchRepositoryImpl: MatchRepositoryImpl,
                             val localRepositoryImpl: LocalRepositoryImpl,
                             val scheduler: SchedulerProvider) : FavoriteMatchContract.Presenter{

    val compositeDisposable = CompositeDisposable()

    override fun getFootballMatchData() {
        mView.showLoading()
        val favList = localRepositoryImpl.getMatchFromDb()
        var eventList: MutableList<Event> = mutableListOf()
        for (fav in favList){
            compositeDisposable.add(matchRepositoryImpl.getEventById(fav.idEvent)
                    .observeOn(scheduler.ui())
                    .subscribeOn(scheduler.io())
                    .subscribe{
                        eventList.add(it.events[0])
                        mView.displayFootballMatch(eventList)
                        mView.hideLoading()
                        mView.hideSwipeRefresh()
                    })
        }

        if(favList.isEmpty()){
            mView.hideLoading()
            mView.hideSwipeRefresh()
            mView.displayFootballMatch(eventList)
        }
    }
}