package org.cazait.cazaitandroid.feature.mypage.navigation

import androidx.navigation.NavGraphBuilder
import org.cazait.cazaitandroid.feature.mypage.api.MyPageNavGraph
import org.cazait.cazaitandroid.feature.mypage.api.MyPageNavGraphInfo
import javax.inject.Inject

internal class MyPageNavGraphImpl @Inject constructor() : MyPageNavGraph {
    override fun buildNavGraph(navGraphBuilder: NavGraphBuilder, navInfo: MyPageNavGraphInfo) {
        navGraphBuilder.myPageNavGraph(
            navInfo.padding,
            navInfo.onSignIn,
            navInfo.onShowErrorSnackbar,
        )
    }
}