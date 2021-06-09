package com.devatacreative.ayohealthy.model

import com.google.gson.annotations.SerializedName

data class UserMenuRecommendation(

	@field:SerializedName("recommended_fnb")
	val recommendedFnb: List<RecommendedFnbItem?>? = null,

	@field:SerializedName("code")
	val code: Int? = null,

	@field:SerializedName("user_data")
	val userData: UserData? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: String? = null
)

data class RecommendedFnbItem(

	@field:SerializedName("fiber")
	val fiber: Double? = null,

	@field:SerializedName("vitamin_a")
	val vitaminA: Double? = null,

	@field:SerializedName("carbs")
	val carbs: Double? = null,

	@field:SerializedName("food_code")
	val foodCode: Int? = null,

	@field:SerializedName("image_url")
	val imageUrl: String? = null,

	@field:SerializedName("vitamin_c")
	val vitaminC: Double? = null,

	@field:SerializedName("vitamin_d")
	val vitaminD: Double? = null,

	@field:SerializedName("vitamin_e")
	val vitaminE: Double? = null,

	@field:SerializedName("vitamin_b6")
	val vitaminB6: Double? = null,

	@field:SerializedName("calories")
	val calories: Double? = null,

	@field:SerializedName("protein")
	val protein: Double? = null,

	@field:SerializedName("fat")
	val fat: Double? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("vitamin_b12")
	val vitaminB12: Double? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("category")
	val category: String? = null,

	@field:SerializedName("sugar")
	val sugar: Double? = null
)

data class UserData(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("email")
	val email: String? = null,

	@field:SerializedName("username")
	val username: String? = null
)
