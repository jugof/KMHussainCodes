const serverApi = "/api/sales"; 

function App() {
	const orderInput = React.useRef({
		'customerId': '', 
		'productNo': 0, 
		'quantity': 0
	});
	const [customerOrders, setCustomerOrders] = React.useState([]);
	const [statusMessage, setStatusMessage] = React.useState('');
	const getOrders = async () => {
		var response = await fetch(`${serverApi}/${orderInput.current.customerId}`);
		if(response.ok) {
			setCustomerOrders(await response.json());
			setStatusMessage('');
		}else{
			setCustomerOrders([]);
			setStatusMessage('Cannot fetch orders!');
		}
	};
	const postOrder = async () => {
		setCustomerOrders([]);
		var request = {
			method: 'post',
			headers: {'Content-Type': 'application/json'},
			body: JSON.stringify(orderInput.current)
		};
		var response = await fetch(serverApi, request);
		if(response.ok){
			var result = await response.json();
			setStatusMessage(`Order ${result.orderNo} placed.`);
		}else{
			setStatusMessage('Cannot place order!');
		}
	};
	return (
		<div>
			<h1>Welcome Sales Agent</h1>
			<hr/>
			<p>
				<b>Customer ID: </b>
				<input onChange={e => orderInput.current.customerId = e.target.value}/>
				<span> </span>
				<button onClick={getOrders}>Lookup</button>
			</p>
			<hr/>
			<div className='form-entry'>
				<div><b>Product No</b></div>
				<div>
					<input onChange={e => orderInput.current.productNo = e.target.value}/>
				</div>
			</div>
			<div className='form-entry'>
				<div><b>Quantity</b></div>
				<div>
					<input onChange={e => orderInput.current.quantity = e.target.value}/>
				</div>
			</div>
			<button onClick={postOrder}>Order</button>
			<hr/>
			<h4>{statusMessage}</h4>
			<InvoiceView ordersList={customerOrders}/>
		</div>
	)
}

function InvoiceView({ordersList}) {
	return (
		<div>
		{ordersList.length > 0 ? (
			<table>
				<thead>
					<tr>
						<th>Product No</th>
						<th>Quantity</th>
						<th>Order Date</th>
					</tr>
				</thead>
				{ordersList.map((entry, index) => (
					<tbody key={index}>
						<tr>
							<td>{entry.productNo}</td>
							<td>{entry.quantity}</td>
							<td>{entry.orderDate.substring(0, 10)}</td>
						</tr>
					</tbody>
				))}
			</table>
		) : null}
		</div>
	)
}


ReactDOM.createRoot(document.getElementById('root')).render(
	<React.StrictMode>
		<App/>
	</React.StrictMode>
);



