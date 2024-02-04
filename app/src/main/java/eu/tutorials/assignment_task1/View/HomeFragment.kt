package eu.tutorials.assignment_task1.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import eu.tutorials.assignment_task1.R
import eu.tutorials.assignment_task1.ViewModel.ItemViewModel
import eu.tutorials.assignment_task1.adapter.RecyclerAdapter
import eu.tutorials.assignment_task1.databinding.FragmentHomeBinding
import eu.tutorials.assignment_task1.model.Shopping


class HomeFragment : Fragment() {
    private lateinit var adapter: RecyclerAdapter
    private lateinit var recyclerView: RecyclerView
    private  var itemArrayList: ArrayList<Shopping> = ArrayList()
    private lateinit var  itemViewModel: ItemViewModel

    private val mBinding: FragmentHomeBinding by lazy {
        FragmentHomeBinding.inflate(layoutInflater)

    }
//    lateinit var image: Array<Int>
//    lateinit var icon: Array<Int>
//    lateinit var description: Array<String>
//    lateinit var name: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        itemViewModel = ViewModelProvider(requireActivity()).get(ItemViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        dataInitialize()
        val layoutManager = GridLayoutManager(requireContext(), 2)
        recyclerView = view.findViewById(R.id.recycle_view)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = RecyclerAdapter(requireContext())
        recyclerView.adapter = adapter
//        Log.d(" API1","HomeFragment")
        itemViewModel.getData()
        itemViewModel.item.observe(viewLifecycleOwner, Observer {
            adapter.getList(it)

        })

    }



//    fun onclick(position: Int, data: Bundle) {
//        Toast.makeText(requireContext(), "" + position, Toast.LENGTH_SHORT).show()
//        val bundle: Bundle = data
//        val frag2 = FragmentTwo()
//        frag2.arguments = bundle
////        frag2.viewModel.dataItem=data
//        val transac =
//            this.parentFragmentManager.beginTransaction().replace(R.id.frame_layout, frag2)
//                .addToBackStack(null)
//        transac.commit()
//    }
}