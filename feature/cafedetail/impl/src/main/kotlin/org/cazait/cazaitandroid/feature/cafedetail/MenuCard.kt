package org.cazait.cazaitandroid.feature.cafedetail

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.cazait.cazaitandroid.core.designsystem.component.CazaitCard
import org.cazait.cazaitandroid.core.designsystem.component.NetworkImage
import org.cazait.cazaitandroid.core.designsystem.theme.CazaitTheme
import org.cazait.cazaitandroid.core.designsystem.theme.Red03
import org.cazait.cazaitandroid.core.designsystem.theme.SunsetOrange
import org.cazait.cazaitandroid.core.repo.cafedetail.api.model.CafeMenu
import org.cazait.cazaitandroid.core.repo.cafedetail.api.model.MenuDescription
import org.cazait.cazaitandroid.core.repo.cafedetail.api.model.MenuId
import org.cazait.cazaitandroid.core.repo.cafedetail.api.model.MenuImage
import org.cazait.cazaitandroid.core.repo.cafedetail.api.model.MenuName
import org.cazait.cazaitandroid.core.repo.cafedetail.api.model.MenuPrice

@Composable
internal fun MenuCard(
    menu: CafeMenu,
    modifier: Modifier = Modifier,
) {
    CazaitCard(
        modifier = modifier,
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 24.dp, vertical = 12.dp),
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            NetworkImage(
                imageUrl = menu.imageUrl.asString(),
                placeholder = painterResource(id = org.cazait.cazaitandroid.core.ui.R.drawable.logo_cazait_main),
                modifier = Modifier
                    .size(width = 100.dp, height = 84.dp)
                    .align(Alignment.CenterVertically)
                    .border(width = 1.dp, color = SunsetOrange, shape = RoundedCornerShape(5.dp))
                    .padding(1.dp)
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = menu.name.asString(),
                        style = CazaitTheme.typography.titleMediumB
                    )
                    Text(
                        text = stringResource(
                            R.string.menu_price_with_unit,
                            menu.price.asInt()
                        ),
                        style = CazaitTheme.typography.titleSmallM,
                        color = Red03
                    )
                }
                Text(
                    text = menu.description.asString(),
                    style = CazaitTheme.typography.bodySmallR
                )
            }
        }
    }
}


@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
private fun PreviewMenuCard() {
    CazaitTheme {
        MenuCard(
            menu = CafeMenu(
                menuId = MenuId(0),
                name = MenuName("아메리카노"),
                description = MenuDescription("우리나라 원두를 사용하여 더욱 달달한 풍미가 살아있는 아메리카노"),
                price = MenuPrice(3500),
                imageUrl = MenuImage("")
            )
        )
    }
}