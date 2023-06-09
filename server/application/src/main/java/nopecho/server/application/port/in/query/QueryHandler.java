package nopecho.server.application.port.in.query;

import nopecho.server.application.port.in.query.result.QueryResult;

public interface QueryHandler {

    boolean canHandle(Query query);

    QueryResult handle(Query query);

    default <T extends Query> T casting(Query query, Class<T> classOfT) {
        return classOfT.cast(query);
    }
}
