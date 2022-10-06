package com.dacha.hellokotlin8

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.dacha.hellokotlin8.databinding.FragmentFirstBinding

class firstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding
    private  var data = arrayListOf<Car>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater , container , false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = CarAdapter(data, this::OnClick)
        binding.recyclerview.adapter = adapter
        loaddata()
    }

    private fun loaddata() {
        data.add(Car("Silvia s15" ,"Nissan Silvia — спортивное купе, выпускавшееся японским автопроизводителем Nissan с 1965 по 2002 годы. Купе строилось на платформе Nissan S. Хотя и последние модели разделяли это шасси с другими автомобилями Nissan (в первую очередь европейская 200SX и североамериканская 240SX в поколениях S13 и S14, и модель 180SX на японском рынке), название Silvia на эти автомобили совместно с кодами шасси не переходило", R.drawable.james))
        data.add(Car("BMW E36" ,"BMW 3-й серии (E36) — третье поколение легковых автомобилей 3-й серии немецкого автоконцерна BMW, выпускавшееся с 1990 по 2000 год. Модели этого поколения стали больше, получили элегантный обтекаемый кузов и изначально создавались как четырёхдверные, в отличие от в основном двухдверных автомобилей второго поколения.", R.drawable.niknak))
        data.add(Car("Mark 2" ,"четырёхдверный спортивный среднеразмерный седан, выпускавшийся компанией Toyota с 1968 по 2004 годы. Наименование Mark II использовалось компанией Toyota на протяжении нескольких десятилетий и первоначально использовалось в составе названия Toyota Corona Mark II. Отметка II была введена, чтобы машина выделялась из основной платформы Toyota Corona. Как только в 1970-е годы платформа была разделена, автомобиль стал известен просто как Mark II.", R.drawable.daigo))
        data.add(Car(" GTR 35" ,"Nissan GT-R  — спорткар, выпускаемый компанией Nissan Motor. Представлен в качестве серийной модели на Токийском автосалоне 24 октября 2007 года, продажи начались в 2008 году в Японии, затем в США и Европе. В отличие от предшественников, выпускавшихся только для JDM и ограниченным тиражом поставлявшихся в Великобританию, имеется вариант с левым рулём.", R.drawable.cawabata))
    }

    private fun OnClick(pos:Int){
        val bundle = Bundle()
        bundle.putSerializable("key" , data[pos])
        findNavController().navigate(R.id.secondFragment , bundle)


    }

}