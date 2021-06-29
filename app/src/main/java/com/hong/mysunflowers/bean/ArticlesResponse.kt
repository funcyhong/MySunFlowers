package com.hong.mysunflowers.bean

/**
 * Created by funcyhong
 * Date 2021/6/21 17:50
 * Description 导航外层数据
 */
data class ArticlesResponse(
  var articles : List<ArticlesBean>,
  var cid : Int,
  var name : String
)