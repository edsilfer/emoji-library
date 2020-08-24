package br.com.instachat.emojilibrary.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import br.com.instachat.emojilibrary.R
import br.com.instachat.emojilibrary.model.Emoji
import br.com.instachat.emojilibrary.view.EmojiTextView

class EmojiAdapter @JvmOverloads constructor(
        ctx: Context,
        data: List<Emoji?>?,
        private val useSystemDefault: Boolean)
    : ArrayAdapter<Emoji?>(
        ctx,
        R.layout.rsc_emoji_item,
        data!!
) {


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView
        if (view == null) {
            view = View.inflate(context, R.layout.rsc_emoji_item, null)
            view.tag = ViewHolder(view, useSystemDefault)
        }

        if (null != getItem(position)) {
            val emoji = getItem(position)
            val holder = view!!.tag as ViewHolder
            holder.icon.text = emoji!!.emoji
        }

        return view!!
    }

    internal class ViewHolder(view: View?, useSystemDefault: Boolean?) {
        var icon: EmojiTextView = view!!.findViewById<View>(R.id.emoji_icon) as EmojiTextView

        init {
            icon.setUseSystemDefault(useSystemDefault!!)
        }
    }
}