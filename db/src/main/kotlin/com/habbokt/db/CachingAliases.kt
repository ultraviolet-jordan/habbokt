package com.habbokt.db

/**
 * @author Jordan Abraham
 */
sealed class CachingAliases {
    companion object {
        const val SiteTableCache = "site_table_cache"
        const val PlayersTableCache = "players_table_cache"
        const val RoomsCategoriesTableCache = "rooms_categories_table_cache"
    }
}