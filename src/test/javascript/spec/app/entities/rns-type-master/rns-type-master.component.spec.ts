/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { Observable } from 'rxjs/Observable';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { JhipsterSampleApplicationTestModule } from '../../../test.module';
import { RNS_TYPE_MASTERComponent } from '../../../../../../main/webapp/app/entities/rns-type-master/rns-type-master.component';
import { RNS_TYPE_MASTERService } from '../../../../../../main/webapp/app/entities/rns-type-master/rns-type-master.service';
import { RNS_TYPE_MASTER } from '../../../../../../main/webapp/app/entities/rns-type-master/rns-type-master.model';

describe('Component Tests', () => {

    describe('RNS_TYPE_MASTER Management Component', () => {
        let comp: RNS_TYPE_MASTERComponent;
        let fixture: ComponentFixture<RNS_TYPE_MASTERComponent>;
        let service: RNS_TYPE_MASTERService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [JhipsterSampleApplicationTestModule],
                declarations: [RNS_TYPE_MASTERComponent],
                providers: [
                    RNS_TYPE_MASTERService
                ]
            })
            .overrideTemplate(RNS_TYPE_MASTERComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(RNS_TYPE_MASTERComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(RNS_TYPE_MASTERService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN
                const headers = new HttpHeaders().append('link', 'link;link');
                spyOn(service, 'query').and.returnValue(Observable.of(new HttpResponse({
                    body: [new RNS_TYPE_MASTER(123)],
                    headers
                })));

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(service.query).toHaveBeenCalled();
                expect(comp.rNS_TYPE_MASTERS[0]).toEqual(jasmine.objectContaining({id: 123}));
            });
        });
    });

});
