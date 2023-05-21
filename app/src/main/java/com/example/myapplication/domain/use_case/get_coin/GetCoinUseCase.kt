package com.example.myapplication.domain.use_case.get_coin

import com.example.myapplication.data.Resource
import com.example.myapplication.data.remote.dto.toCoin
import com.example.myapplication.data.remote.dto.toCoinDetail
import com.example.myapplication.domain.model.Coin
import com.example.myapplication.domain.model.CoinDetail
import com.example.myapplication.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject  constructor(
    private val repository: CoinRepository
) {
    operator  fun invoke(coindId: String) : Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            val coin = repository.getCoinById(coindId).toCoinDetail()
            emit(Resource.Success(coin))
        }catch (e: HttpException)
        {
            emit(Resource.Error(e.localizedMessage))
        }catch (e: IOException)
        {
            emit(Resource.Error(e.localizedMessage))
        }
    }

}