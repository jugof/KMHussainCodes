using System.Data;
using Microsoft.Data.SqlClient;

string customerId = args[0].ToUpper();
int productNo = int.Parse(args[1]);
int quantity = int.Parse(args[2]);
using var connection = new SqlConnection("Data Source=iitdac.met.edu;Database=Shop;User Id=dac;Password=Dac@1234;Encrypt=False");
connection.Open();
using var command = connection.CreateCommand();
command.CommandText = "PlaceOrder";
command.CommandType = CommandType.StoredProcedure;
command.Parameters.AddWithValue("@Customer", customerId);
command.Parameters.AddWithValue("@Product", productNo);
command.Parameters.AddWithValue("@Quantity", quantity);
var orderNoParam = command.Parameters.Add("@OrderId", SqlDbType.Int);
orderNoParam.Direction = ParameterDirection.Output;
try
{
    decimal payment = Convert.ToDecimal(command.ExecuteScalar());
    Console.WriteLine("New order number is {0} with payment of {1:0.00}", orderNoParam.Value, payment);
}
catch(Exception ex)
{
    Console.WriteLine("Order Failed: {0}", ex.Message);
}
