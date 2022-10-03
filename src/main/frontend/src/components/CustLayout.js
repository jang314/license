import * as React from 'react';
import CssBaseline from '@mui/material/CssBaseline';
import Box from '@mui/material/Box';
import Container from '@mui/material/Container';
import Paper from '@mui/material/Paper';
import Grid from '@mui/material/Grid';
import Typography from '@mui/material/Typography';

export default function SimpleContainer() {
    return (
        <React.Fragment>
            <CssBaseline />
            <Container maxWidth="xl" sx={{ p : '50px'}}>
                <Box sx={{  height: '100vh', flexGrow : 1}} >
                    <Grid container spacing={2}>
                        <Grid item xs={3} >
                            <Typography>고객사 유형</Typography>
                        </Grid>
                        <Grid item xs={6}>
                            2
                        </Grid>

                    </Grid>
                </Box>
            </Container>
        </React.Fragment>
    );
}