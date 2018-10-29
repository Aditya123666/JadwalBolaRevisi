package com.aditya.lenovo.jadwalbolarevisi.Main.PertandinganTerakhir

import com.aditya.lenovo.jadwalbolarevisi.Entitas.repository.MatchRepositoryImpl
import com.aditya.lenovo.jadwalbolarevisi.scheduler.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

class LastMatchPresenter(val mView :  MatchContract.View,
                         val matchRepositoryImpl: MatchRepositoryImpl,
                         val scheduler: SchedulerProvider) : MatchContract.Presenter{

    val compositeDisposable = CompositeDisposable()

    override fun getFootballMatchData() {
        mView.showLoading()
        compositeDisposable.add(matchRepositoryImpl.getFootballMatch("4328")
                .observeOn(scheduler.ui())
                .subscribeOn(scheduler.io())
                .subscribe{
                    mView.displayFootballMatch(it.events)
                    mView.hideLoading()
                })
    }
}