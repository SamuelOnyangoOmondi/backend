module.exports = {
  development: {
    client: 'pg',
    connection: process.env.DATABASE_URL || 'postgres://farmtopalm:farmtopalm_secret@localhost:5432/farmtopalm',
    migrations: { directory: './src/db/migrations', extension: 'cjs' },
  },
  production: {
    client: 'pg',
    connection: process.env.DATABASE_URL,
    migrations: { directory: './src/db/migrations', extension: 'cjs' },
  },
};
