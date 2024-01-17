package org.cazait.cazaitandroid.core.repo.cafedetail.api.model

data class CafeMenu(
    val menuId: MenuId,
    val name: MenuName,
    val description: MenuDescription,
    val price: MenuPrice,
    val imageUrl: MenuImage,
)

@JvmInline
value class CafeMenus(private val menus: List<CafeMenu>) {
    fun asList(): List<CafeMenu> = menus
}