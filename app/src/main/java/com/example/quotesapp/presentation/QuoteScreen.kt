package com.example.quotesapp.presentation

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import com.example.quotesapp.model.data.Quote

@Composable
fun QuotesCard(modifier: Modifier = Modifier,
               quote: Quote,
               isFavorite: Boolean,
               onFavoriteClick:(Quote)-> Unit) {
    val context= LocalContext.current
    ElevatedCard(modifier= Modifier
        .fillMaxWidth()
        .height(170.dp)
        .padding(12.dp),
        colors = CardDefaults.cardColors(
        containerColor = Color.White,

    )) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(7.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
        Text(quote.quote,
            style = MaterialTheme.typography.titleMedium)
            Spacer(modifier.padding(5.dp))
        Text(quote.author,
            style = MaterialTheme.typography.labelMedium)
            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center) {
                IconButton( onClick = {
                    onFavoriteClick(quote)
                }) {
                    Icon(
                        imageVector = if (!isFavorite) Icons.Default.FavoriteBorder
                        else Icons.Default.Favorite,
                        contentDescription = null
                    )
                }
                Spacer(modifier = Modifier.padding(horizontal = 4.dp))
                IconButton(onClick = {
                   Intent(Intent.ACTION_SEND)
                        .also {
                            it.putExtra(Intent.EXTRA_TEXT,quote.quote)
                            it.type="text/plain"
                            if (it.resolveActivity(context.packageManager)!=null)
                            {
                                context.startActivity(it)
                            }
                        }
                }) {
                    Icon(
                        imageVector = Icons.Default.Share,
                        contentDescription = null
                    )
                }
            }

    }}
}

