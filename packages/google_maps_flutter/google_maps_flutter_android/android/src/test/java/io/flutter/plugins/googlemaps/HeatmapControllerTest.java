package io.flutter.plugins.googlemaps;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;


import com.google.android.gms.internal.maps.zzaj;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.TileOverlay;
import com.google.maps.android.heatmaps.HeatmapTileProvider;
import com.google.maps.android.heatmaps.WeightedLatLng;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class HeatmapControllerTest {

    @Test
    public void controller_SetsRadiusHeatmap() {
        final zzaj z = mock(zzaj.class);
        final List<WeightedLatLng> list = new ArrayList<>();
        list.add(new WeightedLatLng(new LatLng(0.0, 0.0), 0));
        final TileOverlay tileOverlay = new TileOverlay(z);
        final HeatmapTileProvider heatmapTileProvider = spy(new HeatmapTileProvider.Builder().weightedData(list).build());
        final HeatmapController heatmapController = new HeatmapController(heatmapTileProvider, tileOverlay);
        heatmapController.setRadius(30);
        Mockito.verify(heatmapTileProvider).setRadius(30);
    }
}
