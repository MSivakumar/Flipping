package com.project.uthayan.manualflipping

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import android.content.Context
import android.support.v7.app.AlertDialog
/**
 * Display details of the presentation
 * Add this component <class> to the lifecycleobserver where we need to display dialog when click icon
 * example
 *          //code here
 *          lifecycle.addObserver(Component(..... , ..... , .....))
 *          //code here
 */
class Component(var context: Context, var detaildialoguebox: Detaildialoguebox, var string: String) : LifecycleObserver {

    var isVissible : Boolean = true

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    internal fun onCreate() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    internal fun onStart() {
        detaildialoguebox.CreateDialog(context,string)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    internal fun onStop() {
        detaildialoguebox.myAlertDialog!!.dismiss()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    internal fun onPause() {
        isVissible = detaildialoguebox.myAlertDialog!!.isShowing
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    internal fun onResume() {
        if(isVissible)
            detaildialoguebox.myAlertDialog!!.show()
    }
}

class Detaildialoguebox {

    var myAlertDialog: AlertDialog? = null

    fun CreateDialog (context: Context, string: String) {
        val alertDialog = AlertDialog.Builder(context)
        alertDialog.setTitle("Details")
        alertDialog.setMessage(string)
        myAlertDialog = alertDialog.create()
    }
}