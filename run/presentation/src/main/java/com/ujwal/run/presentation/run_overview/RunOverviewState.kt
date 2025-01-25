package com.ujwal.run.presentation.run_overview

import com.ujwal.run.presentation.run_overview.model.RunUi

data class RunOverviewState(
    val runs: List<RunUi> = emptyList()
)