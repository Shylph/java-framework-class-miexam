package kr.ac.jejunu;

public class DaoFactory {

    public ProductDao getProductDao() {
        return new ProductDao(getConnectionMaker());
    }

    private ConnectionMaker getConnectionMaker() {
        return new JejuConnectionMaker();
    }

}
