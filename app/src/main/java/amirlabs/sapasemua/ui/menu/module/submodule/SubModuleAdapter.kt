package amirlabs.sapasemua.ui.menu.module.submodule

import amirlabs.sapasemua.R
import amirlabs.sapasemua.data.model.SubModule
import amirlabs.sapasemua.databinding.ItemCreateVideoBinding
import amirlabs.sapasemua.databinding.ItemSubmoduleBinding
import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView

class SubModuleAdapter(private val onItemClick: (SubModule) -> Unit) :
    RecyclerView.Adapter<SubModuleAdapter.ViewHolder>() {
    val listData = ArrayList<SubModule>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubModuleAdapter.ViewHolder {
        val view: ItemSubmoduleBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_submodule, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = listData.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(list: List<SubModule>) {
        this.listData.clear()
        this.listData.addAll(list)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: SubModuleAdapter.ViewHolder, position: Int) {
        holder.bind(listData[position], position)
    }

    inner class ViewHolder(private val binding: ItemSubmoduleBinding) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(data: SubModule, position: Int) {
            with(binding) {
                tvSubmoduleTitle.text = data.name
                tvSubmoduleTime.text = "${data.duration ?: 10} minutes"
                binding.root.setOnClickListener { onItemClick(data) }
            }
        }
    }
}