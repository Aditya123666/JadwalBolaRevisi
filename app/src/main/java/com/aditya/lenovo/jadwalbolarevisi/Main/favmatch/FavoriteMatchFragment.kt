package com.aditya.lenovo.jadwalbolarevisi.Main.favmatch

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.aditya.lenovo.jadwalbolarevisi.R
import com.aditya.lenovo.jadwalbolarevisi.adapter.Adapter
import com.aditya.lenovo.jadwalbolarevisi.Entitas.Event
import com.aditya.lenovo.jadwalbolarevisi.Entitas.repository.LocalRepositoryImpl
import com.aditya.lenovo.jadwalbolarevisi.Entitas.repository.MatchRepositoryImpl
import com.aditya.lenovo.jadwalbolarevisi.extensions.hide
import com.aditya.lenovo.jadwalbolarevisi.extensions.show
import com.aditya.lenovo.jadwalbolarevisi.api.FootballApiService
import com.aditya.lenovo.jadwalbolarevisi.api.FootballRest
import com.aditya.lenovo.jadwalbolarevisi.scheduler.AppSchedulerProvider
import kotlinx.android.synthetic.main.fragment_favorite_match.*

class FavoriteMatchFragment : Fragment(), FavoriteMatchContract.View {
    private var matchLists : MutableList<Event> = mutableListOf()
    lateinit var mPresenter : FavoriteMatchPresenter

    override fun hideLoading() {
        mainProgressBar.hide()
        rvFootball.visibility = View.VISIBLE
    }

    override fun showLoading() {
        mainProgressBar.show()
        rvFootball.visibility = View.INVISIBLE
    }

    override fun displayFootballMatch(matchList: List<Event>) {
        matchLists.clear()
        matchLists.addAll(matchList)
        val layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        rvFootball.layoutManager = layoutManager
        rvFootball.adapter = Adapter(matchList, context)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val service = FootballApiService.getClient().create(FootballRest::class.java)
        val request = MatchRepositoryImpl(service)
        val localRepositoryImpl = LocalRepositoryImpl(context!!)
        val scheduler = AppSchedulerProvider()
        mPresenter = FavoriteMatchPresenter(this, request, localRepositoryImpl, scheduler)
        mPresenter.getFootballMatchData()

        swiperefresh.setOnRefreshListener {
            mPresenter.getFootballMatchData()
        }

    }

    override fun hideSwipeRefresh() {
        swiperefresh.isRefreshing = false
        mainProgressBar.hide()
        rvFootball.visibility = View.VISIBLE
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite_match, container, false)
    }


}
