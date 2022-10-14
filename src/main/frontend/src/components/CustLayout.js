import * as React from 'react';
import CssBaseline from '@mui/material/CssBaseline';
import Box from '@mui/material/Box';
import Container from '@mui/material/Container';
import Paper from '@mui/material/Paper';
import Grid from '@mui/material/Grid';
import Typography from '@mui/material/Typography';
import Stack from '@mui/material/Stack';
import { styled } from '@mui/material/styles';

const Item = styled(Paper)(({ theme }) => ({
  backgroundColor: theme.palette.mode === 'dark' ? '#1A2027' : '#fff',
  ...theme.typography.body2,
  padding: theme.spacing(1),
  textAlign: 'center',
  color: theme.palette.text.secondary,
}));
export default function SimpleContainer() {
    return (
        <React.Fragment>
            <CssBaseline />
            <Container maxWidth="xl" sx={{ p : '50px'}}>
                <Box sx={{  height: '100vh', flexGrow : 1}} >
                    <Grid container spacing={2}>
                        <Stack spacing={2}>
                          <Item>Item 1</Item>
                          <Item>Item 2</Item>
                          <Item>Item 3</Item>
                        </Stack>
                    </Grid>
                </Box>
            </Container>
        </React.Fragment>
    );
}