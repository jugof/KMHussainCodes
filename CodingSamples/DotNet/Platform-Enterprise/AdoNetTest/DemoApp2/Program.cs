using Microsoft.Data.SqlClient;

using var connection = new SqlConnection("Data Source=iitdac.met.edu;Database=Shop;User Id=dac;Password=Dac@1234;Trust Server Certificate=true");
connection.Open();
