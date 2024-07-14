package com.otakkanan.sinote.ui.components.catatan

import androidx.compose.ui.graphics.Color

data class CatatanDataClass(
    val title: String,
    val content: String,
    val priority: CatatanPriority = CatatanPriority.NONE
)

object CatatanDataDummies {
    val catatanList = listOf(
        CatatanDataClass(
            title = "🚀 Product Launch Plan",
            content = "Detail the steps for the upcoming product launch, including key dates, responsibilities, and expected outcomes.",
            priority = CatatanPriority.UTAMA
        ),
        CatatanDataClass(
            title = "💡 Strategy Meeting Notes",
            content = "Discuss and finalize the marketing strategy for the next quarter. Focus on digital marketing channels.",
            priority = CatatanPriority.PENTING
        ),
        CatatanDataClass(
            title = "💡 New Product Idea Design",
            content = "Create a mobile app UI Kit that provide a basic notes functionality but with some improvement.\n\nThere will be a choice to select what kind of notes that user needed, so the experience while taking notes can be unique based on the needs.\n"
        ),
        CatatanDataClass(
            title = "📋 Daily Standup Notes",
            content = "Summary of what was discussed in today's standup meeting, including project updates and blockers."
        ),
        CatatanDataClass(
            title = "🔧 Technical Review Meeting",
            content = "Review the latest tech stack updates and discuss potential challenges in integration with current systems.",
        ),
        CatatanDataClass(
            title = "🎯 Sales Targets Review",
            content = "Evaluate the sales performance of the last quarter and set targets for the upcoming months.",
        ),
        CatatanDataClass(
            title = "🌍 Global Market Expansion Strategy",
            content = "Outline the strategy for expanding our product reach into new global markets in the next year.",
        ),
        CatatanDataClass(
            title = "📊 Quarterly Financial Report",
            content = "Prepare a detailed financial report for the last quarter, highlighting revenue, expenses, and net profit.",
        ),
        CatatanDataClass(
            title = "👥 HR Policies Update",
            content = "Discuss the upcoming changes to HR policies, including remote work guidelines and employee benefits enhancements.",
            priority = CatatanPriority.NONE
        ),
        CatatanDataClass(
            title = "📝 Content Strategy Meeting",
            content = "Plan the content strategy for the next six months, focusing on key themes, platforms, and engagement metrics.",
            priority = CatatanPriority.NONE
        )
    )
}


enum class CatatanPriority(
    val priority: String,
    val priorityNumber: Int,
    val priorityColor: Color,
    val bgColor: Color,
    val priorityTextColor: Color,
) {
    UTAMA("Prioritas Utama", 1, Color(0xFF6A3EA1), Color(0xFFEFE9F7), Color(0xFFEFE9F7)),
    PENTING("Penting", 2, Color(0xFFEFEEF0), Color(0xFFFFFFFF), Color(0xFF827D89)),
    NONE("", 10, Color(0xFFF7F6D4), Color(0xFFF7F6D4), Color(0xFFF7F6D4))
}
