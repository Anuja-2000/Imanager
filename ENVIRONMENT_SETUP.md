# Environment Setup Guide

## Setting up Environment Variables

This application uses environment variables to store sensitive database credentials securely.

### Step 1: Create .env file

1. Copy the `.env.example` file to `.env`:
   ```
   cp .env.example .env
   ```

2. Edit the `.env` file with your actual database credentials:
   ```properties
   DB_URL=jdbc:mysql://your-host:port/database_name?ssl-mode=REQUIRED
   DB_USERNAME=your_username
   DB_PASSWORD=your_password
   ```

### Step 2: Environment Variables

The application expects the following environment variables:

| Variable | Description | Example |
|----------|-------------|---------|
| `DB_URL` | Complete JDBC URL for MySQL database | `jdbc:mysql://localhost:3306/Imanager_db?ssl-mode=REQUIRED` |
| `DB_USERNAME` | Database username | `root` |
| `DB_PASSWORD` | Database password | `your_password` |

### Step 3: Default Values

The application provides default values if environment variables are not set:
- **DB_URL**: `jdbc:mysql://localhost:3306/Imanager_db?ssl-mode=REQUIRED`
- **DB_USERNAME**: `root`
- **DB_PASSWORD**: `password`

### Security Notes

1. **Never commit the `.env` file** to version control
2. The `.env` file is already added to `.gitignore`
3. Use `.env.example` as a template for team members
4. Keep production credentials separate from development credentials

### Running the Application

1. Ensure your `.env` file is properly configured
2. Start the Spring Boot application
3. The application will automatically load environment variables from the `.env` file

### Troubleshooting

If you encounter database connection issues:

1. Verify your `.env` file exists and contains correct values
2. Check that your database server is running
3. Ensure the database specified in `DB_URL` exists
4. Verify network connectivity to the database server
