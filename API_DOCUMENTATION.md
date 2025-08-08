# Income Management API

This REST API provides CRUD operations for managing income records in the Imanager application.

## Database Schema

The `income` table contains the following columns:
- `id` (Long) - Primary key, auto-generated
- `type` (String) - Type of income (e.g., "Trip", "Delivery")
- `start` (LocalDateTime) - Start time of the income-generating activity
- `end` (LocalDateTime) - End time of the income-generating activity
- `distance` (BigDecimal) - Distance covered
- `price` (BigDecimal) - Price/income amount
- `driver_id` (Long) - ID of the driver

## API Endpoints

### Basic CRUD Operations

#### Create Income Record
- **POST** `/api/incomes`
- **Body**: IncomeDTO JSON object
- **Response**: Created IncomeDTO with generated ID

#### Get All Income Records
- **GET** `/api/incomes`
- **Response**: List of all IncomeDTO objects

#### Get Income Record by ID
- **GET** `/api/incomes/{id}`
- **Response**: IncomeDTO object or 404 if not found

#### Update Income Record
- **PUT** `/api/incomes/{id}`
- **Body**: IncomeDTO JSON object
- **Response**: Updated IncomeDTO object

#### Delete Income Record
- **DELETE** `/api/incomes/{id}`
- **Response**: 204 No Content

### Query Operations

#### Get Income by Driver ID
- **GET** `/api/incomes/driver/{driverId}`
- **Response**: List of IncomeDTO objects for the specified driver

#### Get Income by Type
- **GET** `/api/incomes/type/{type}`
- **Response**: List of IncomeDTO objects of the specified type

#### Get Income by Date Range
- **GET** `/api/incomes/date-range?startDate={startDate}&endDate={endDate}`
- **Parameters**: 
  - `startDate`: ISO format datetime string (e.g., "2023-01-01T00:00:00")
  - `endDate`: ISO format datetime string (e.g., "2023-12-31T23:59:59")
- **Response**: List of IncomeDTO objects within the date range

#### Get Total Income by Driver ID
- **GET** `/api/incomes/total/driver/{driverId}`
- **Response**: BigDecimal representing total income for the driver

#### Get Average Income per Trip
- **GET** `/api/incomes/average`
- **Response**: BigDecimal representing average income per trip

## Sample JSON Request/Response

### Sample IncomeDTO for POST/PUT requests:
```json
{
  "type": "Trip",
  "start": "2024-01-15T10:00:00",
  "end": "2024-01-15T10:30:00",
  "distance": 15.5,
  "price": 25.80,
  "driverId": 1
}
```

### Sample Response:
```json
{
  "id": 1,
  "type": "Trip",
  "start": "2024-01-15T10:00:00",
  "end": "2024-01-15T10:30:00",
  "distance": 15.5,
  "price": 25.80,
  "driverId": 1
}
```

## Error Handling

The API returns appropriate HTTP status codes:
- `200 OK` - Successful GET/PUT operations
- `201 Created` - Successful POST operations
- `204 No Content` - Successful DELETE operations
- `404 Not Found` - Resource not found
- `500 Internal Server Error` - Server errors

Error responses include a JSON object with error details:
```json
{
  "timestamp": "2024-01-15T10:00:00",
  "status": 404,
  "error": "Not Found",
  "message": "Income record not found with id: 999",
  "path": "/api/incomes/999"
}
```

## Running the Application

1. **Environment Setup**: Follow the instructions in `ENVIRONMENT_SETUP.md` to configure your database credentials
2. **Create .env file**: Copy `.env.example` to `.env` and update with your database credentials
3. **Ensure MySQL database is running** and accessible
4. **Run the Spring Boot application**
5. The API will be available at `http://localhost:8080/api/incomes`

## Testing

Sample data is automatically initialized when the application starts if the income table is empty.
