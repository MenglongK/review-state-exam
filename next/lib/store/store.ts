import {configureStore} from "@reduxjs/toolkit";
import {productEndpoint} from "@/lib/feature/productEndpoint";
import {setupListeners} from "@reduxjs/toolkit/query";

export const makeStore = () => {
    const store = configureStore({
        reducer: {
            [productEndpoint.reducerPath]: productEndpoint.reducer,
        },
        middleware: (getDefaultMiddleware) => getDefaultMiddleware()
            .concat(productEndpoint.middleware)
    })
    setupListeners(store.dispatch);
    return store;
}

export type AppStore = ReturnType<typeof makeStore>;
export type RootState = ReturnType<AppStore['getState']>
export type AppDispatch = AppStore['dispatch']