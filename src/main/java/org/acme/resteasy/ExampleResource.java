package org.acme.resteasy;

import io.agroal.api.AgroalDataSource;
import io.quarkus.agroal.DataSource;
import org.acme.resteasy.models.Summary;
import org.acme.resteasy.repositories.SummaryRepository;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Path("/resteasy/hello")
public class ExampleResource {

    private static final String dailyBranchQuery = "SELECT * FROM SummaryBranchDaily;";
    private static final String monthlyBranchQuery = "SELECT * FROM SummaryBranchMonthly;";
    private static final String quarterlyBranchQuery = "SELECT * FROM SummaryBranchQuarterly;";
    private static final String yearlyBranchQuery = "SELECT * FROM SummaryBranchYearly;";

    @Inject
    @DataSource("warehouse")
    AgroalDataSource dataSource;

    @Inject
    SummaryRepository repository;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        collectData(dailyBranchQuery);
        collectData(monthlyBranchQuery);
        collectData(quarterlyBranchQuery);
        collectData(yearlyBranchQuery);

        return "Finished";
    }

    private void collectData(String query) {
        try(Connection cn = dataSource.getConnection();
            PreparedStatement ps = cn.prepareStatement(query);
            ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Summary summary = new Summary();

                Long id = rs.getLong(1);
                summary.setId(id);

                summary.setRevenue(rs.getDouble(2));
                summary.setAdtv(rs.getDouble(3));
                summary.setNoa(rs.getInt(4));
                summary.setAdtvPerNoa(rs.getDouble(5));
                summary.setActiveClient(rs.getInt(6));
                summary.setAdtvPerActive(rs.getDouble(7));
                summary.setAssetGrowth(rs.getDouble(8));
                summary.setMargin(rs.getDouble(9));
                summary.settPlus(rs.getDouble(10));
                summary.setRepo(rs.getDouble(11));

                repository.create(summary);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}