package com.example.thibanglaixe.extension

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.google.android.material.bottomnavigation.BottomNavigationView

class BottomNavigationBehavior(context: Context?, attrs: AttributeSet?) :
    CoordinatorLayout.Behavior<BottomNavigationView>(context, attrs) {

    override fun layoutDependsOn(
        parent: CoordinatorLayout,
        child: BottomNavigationView,
        dependency: View
    ): Boolean {
        return super.layoutDependsOn(parent, child, dependency)
    }

    override fun onNestedScroll(
        coordinatorLayout: CoordinatorLayout,
        child: BottomNavigationView,
        target: View,
        dxConsumed: Int,
        dyConsumed: Int,
        dxUnconsumed: Int,
        dyUnconsumed: Int,
        type: Int,
        consumed: IntArray
    ) {
        super.onNestedScroll(
            coordinatorLayout,
            child,
            target,
            dxConsumed,
            dyConsumed,
            dxUnconsumed,
            dyUnconsumed,
            type,
            consumed
        )
    }

    private fun hideBottomNavigationView(bottomNavigationView: BottomNavigationView){
        val height = bottomNavigationView.height
        bottomNavigationView.animate().translationY(height.toFloat())
    }

    private fun showBottomNavigationView(bottomNavigationView: BottomNavigationView){
        bottomNavigationView.animate().translationY(0F)
    }
}