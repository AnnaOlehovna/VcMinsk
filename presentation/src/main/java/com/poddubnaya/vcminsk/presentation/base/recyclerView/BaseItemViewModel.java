package com.poddubnaya.vcminsk.presentation.base.recyclerView;


public abstract class BaseItemViewModel<Model> {

   public abstract void setItem(Model model, int position);

   public void init(){

   }

   public void release(){

   }

}
