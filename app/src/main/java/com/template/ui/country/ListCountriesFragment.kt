package com.template.ui.country

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.template.R
import com.template.ui.base.BaseFragment
import com.ui_model.country.UiCountry
import com.view_models.country.ListCountriesViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.item_countries_layout.view.*
import kotlinx.android.synthetic.main.list_countries_fragment_layout.*

fun createMainFragment() = ListCountriesFragment()

@AndroidEntryPoint
class ListCountriesFragment :
    BaseFragment<ListCountriesViewModel>(R.layout.list_countries_fragment_layout) {
    override val viewModel by viewModels<ListCountriesViewModel>()
    private val adapter by lazy { ListCountriesAdapter() }
    override fun doInitializations() {
        viewModel.loadAllCountries()
    }

    override fun setupObservers() {
        viewModel.countryListLiveData.observe(viewLifecycleOwner) {
            listCountriesRecyclerView.layoutManager = LinearLayoutManager(context)
            listCountriesRecyclerView.adapter = adapter
            adapter.addItems(it)
        }
    }

    class ListCountriesAdapter :
        RecyclerView.Adapter<ListCountriesAdapter.ListCountriesViewHolder>() {
        private val items = mutableListOf<UiCountry>()
        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): ListCountriesViewHolder {
            return ListCountriesViewHolder(
                LayoutInflater
                    .from(parent.context)
                    .inflate(
                        R.layout.item_countries_layout,
                        parent,
                        false
                    )
            )
        }

        override fun getItemCount() = items.size
        override fun onBindViewHolder(
            holder: ListCountriesViewHolder,
            position: Int
        ) {
            holder.bind(items[position])
        }

        fun addItems(countries: List<UiCountry>) {
            items.addAll(countries)
            notifyDataSetChanged()
        }

        class ListCountriesViewHolder(itemView: View) :
            RecyclerView.ViewHolder(itemView) {
            fun bind(uiCountry: UiCountry) = with(itemView) {
                itemCountriesName.text = uiCountry.name
            }
        }
    }
}