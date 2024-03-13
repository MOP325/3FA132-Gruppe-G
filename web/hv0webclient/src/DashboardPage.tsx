import { Box } from "@mui/material";

const customBoxStyles = {
  Box: {
    minWidth: 400,
    height: 500,
    backgroundColor: "grey.800",
    borderRadius: 15,
    margin: 2,
  },
  BigBox: {
    minWidth: 825,
    height: 500,
    backgroundColor: "grey.800",
    borderRadius: 15,
    margin: 2,
  },
};

export function DashboardPage() {
  return (
    <>
      <Box sx={{ display: "flex" }}>
        <Box
          sx={{
            height: "90vh",
            width: 500,
            backgroundColor: "grey.800",
            margin: 2,
            marginRight: 10,
          }}
        ></Box>
        <Box
          sx={{
            display: "flex",
            flexWrap: "wrap",
            // justifyContent: "space-between",
          }}
        >
          <Box sx={customBoxStyles.Box}></Box>
          <Box sx={customBoxStyles.BigBox}></Box>
          <Box sx={customBoxStyles.Box}></Box>
          <Box sx={customBoxStyles.Box}></Box>
          <Box sx={customBoxStyles.Box}></Box>
        </Box>
      </Box>
      <Box></Box>
    </>
  );
}
