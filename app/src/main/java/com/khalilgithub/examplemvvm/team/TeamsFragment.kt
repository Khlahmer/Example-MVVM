package com.khalilgithub.examplemvvm.team

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.khalilgithub.examplemvvm.databinding.TeamsFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TeamsFragment : Fragment() {

    private lateinit var binding: TeamsFragmentBinding
    private val teamsViewModel: TeamsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = TeamsFragmentBinding.inflate(layoutInflater)
        return (binding.root)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        initView()
    }

    private fun initView() {
        var arrayAdapter: ArrayAdapter<String>
        var data = ArrayList<String>()

        teamsViewModel.fetchTeams()
        teamsViewModel.info.observe(viewLifecycleOwner) {
            for (teams in it) {
                data.add(teams.full_name)
            }
            arrayAdapter = ArrayAdapter(
                requireView().context,
                R.layout.simple_list_item_1, data
            )
            binding.listViewTeams.adapter = arrayAdapter
        }

    }
}