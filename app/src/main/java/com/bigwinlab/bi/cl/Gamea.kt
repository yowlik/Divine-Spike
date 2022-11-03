package com.bigwinlab.bi.cl

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.bigwinlab.bi.R
import com.bigwinlab.bi.databinding.ActivityGameaBinding

class Gamea : AppCompatActivity() {
    lateinit var binding:ActivityGameaBinding
    lateinit var buts:Array<Button>
    var last=0
    var scr=0
    val roll= mutableListOf<Int>(1,1,1,1,1,2)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityGameaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        buts= arrayOf(binding.im1,binding.im2,binding.im3,binding.im4,binding.im5,binding.im6)
        for (i in 0..5){
            buts[i].setVisibility(View.GONE)

        }
        binding.starter.setOnClickListener {
            binding.starter.setVisibility(View.GONE)
            binding.scoret.text="Find a wolf in sheep's clothing"
            roll.shuffle()
            scr=0
            for (i in 0..5){
                buts[i].setBackgroundResource(R.drawable.good)
                buts[i].setVisibility(View.VISIBLE)
                buts[i].setOnClickListener {
                    check(roll[i],buts[i])
                    if(buts[i].text=="2"){
                        last=i
                        for(i in 0..5){
                            buts[i].setVisibility(View.GONE)
                            buts[last].setVisibility(View.VISIBLE)
                            binding.scoret.text="You find the wolf"
                            binding.starter.setVisibility(View.VISIBLE)

                        }
                    }
                    else if(buts[i].text=="1"){
                        scr++
                        if(scr==3){
                            for(i in 0..5){
                                buts[i].setVisibility(View.GONE)
                                binding.scoret.text="You cant find the wolf"
                                binding.starter.setVisibility(View.VISIBLE)

                            }

                        }

                    }

                }

            }
        }


    }

    private fun check(i:Int,im:Button){
        if(i==1){
            im.setText("1")
            im.setVisibility(View.GONE)
        }
        else{
            im.setText("2")
            im.setBackgroundResource(R.drawable.bad)
        }
    }
}