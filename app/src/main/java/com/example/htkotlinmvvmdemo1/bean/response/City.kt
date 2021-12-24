package com.example.htkotlinmvvmdemo1.bean.response

data class City(
    var rows: List<Row>?,
    var total: Int?
)
data class Row(
    var adcode: String?,
    var lat: Double?,
    var level: String?,
    var lng: Double?,
    var name: String?,
    var parent: String?,
    var people_count_2010: Int?
)