package org.cazait.cazaitandroid.core.repo.cafedetail.mapper

import org.cazait.cazaitandroid.core.repo.cafedetail.api.model.CafeMenu
import org.cazait.cazaitandroid.core.repo.cafedetail.api.model.MenuDescription
import org.cazait.cazaitandroid.core.repo.cafedetail.api.model.MenuId
import org.cazait.cazaitandroid.core.repo.cafedetail.api.model.MenuImage
import org.cazait.cazaitandroid.core.repo.cafedetail.api.model.MenuName
import org.cazait.cazaitandroid.core.repo.cafedetail.api.model.MenuPrice
import org.cazait.cazaitandroid.core.repo.cafedetail.network.model.CafeMenuResponse

internal fun CafeMenuResponse.toData(): CafeMenu = CafeMenu(
    menuId = MenuId(menuId),
    name = MenuName(name),
    description = MenuDescription(description),
    price = MenuPrice(price),
    imageUrl = MenuImage(imageUrl),
)