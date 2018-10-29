package com.aditya.lenovo.jadwalbolarevisi.Main.main

import com.aditya.lenovo.jadwalbolarevisi.Entitas.repository.MatchRepositoryImpl
import io.reactivex.disposables.CompositeDisposable

class MainPresenter(val mView : MainContract.View, val matchRepositoryImpl: MatchRepositoryImpl) : MainContract.Presenter{

    val compositeDisposable = CompositeDisposable()
}