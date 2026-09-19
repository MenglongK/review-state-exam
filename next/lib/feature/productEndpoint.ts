import {apiSlice} from "@/lib/api/apiSlice";
import {Product} from "@/type/product"

export const productEndpoint = apiSlice.injectEndpoints({
    endpoints: (builder) => ({
        getProducts: builder.query<Product, void>({
            query: () => 'products',
            providesTags: ['Product']
        })
    })
})

export const {
    useGetProductsQuery
} = productEndpoint;